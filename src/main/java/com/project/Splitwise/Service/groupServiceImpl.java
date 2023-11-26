package com.project.Splitwise.Service;
import com.project.Splitwise.DTO.TransactionDTO;
import com.project.Splitwise.Exception.GroupNotFoundException;
import com.project.Splitwise.Models.Group;
import com.project.Splitwise.Repository.GroupRepository;
import com.project.Splitwise.Service.Strategy.SettleUpStrategy;
import com.project.Splitwise.Service.Strategy.SettleUpStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class groupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<TransactionDTO> settleUpByGroupId(int groupId) throws GroupNotFoundException {

        SettleUpStrategy strategy = SettleUpStrategyFactory.getSettleUpStrategy();
        Optional<Group> savedGroup = groupRepository.findById(groupId);
        if (savedGroup.isEmpty()) {
            throw new GroupNotFoundException("Group Not Found for the Given Group ID:" + groupId);
        }

        List<TransactionDTO> transactions = strategy.settleUp(savedGroup.get().getExpenses());
        return transactions;
    }
}
