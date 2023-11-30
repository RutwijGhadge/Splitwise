package com.project.Splitwise.Service.IMPLs;

import com.project.Splitwise.DTO.ExpenseDTO;
import com.project.Splitwise.Exception.GroupNotFoundException;
import com.project.Splitwise.Models.Expense;
import com.project.Splitwise.Models.Group;
import com.project.Splitwise.Repository.ExpenseRepository;
import com.project.Splitwise.Repository.GroupRepository;
import com.project.Splitwise.Service.ExpenseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ModelMapper modelmapper;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private GroupRepository groupRepository;
    //Creating an expense for the Particular Group
    @Override
    public ExpenseDTO createExpenseForGroup(int groupId, ExpenseDTO expenseDTO) throws GroupNotFoundException {
        Expense expense = modelmapper.map(expenseDTO,Expense.class);
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new GroupNotFoundException("Group Id : " + groupId + " is not present to create an expense for group"));

        List<Expense> expenses=group.getExpenses();
        if(expenses==null){
            expenses=new ArrayList<>();
        }
        expenses.add(expense);
        group.setExpenses(expenses);

        Expense savedExpense=expenseRepository.save(expense);
        groupRepository.save(group);

        return modelmapper.map(savedExpense,ExpenseDTO.class);
    }

    @Override
    public double getTotalAmountForExpense(int expenseId) throws GroupNotFoundException {
        return 0;
    }


}
