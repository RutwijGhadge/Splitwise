package com.project.Splitwise.controller;
import com.project.Splitwise.Service.GroupService;
import com.project.Splitwise.DTO.TransactionDTO;
import com.project.Splitwise.Exception.GroupNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/settleUp/{groupId}")
    public ResponseEntity settleUpForGroup(@PathVariable("groupId") int groupId) throws GroupNotFoundException {
        List<TransactionDTO> transactions = groupService.settleUpByGroupId(groupId);//calling method from interface i.e service
        return ResponseEntity.ok(transactions);
    }

    //get the total amount spend by a user from a particular group

    @GetMapping("{groupId}/getExpense")//mapping a call
    public ResponseEntity getTotalAmount(@PathVariable("groupId")int groupId) throws GroupNotFoundException {
        double totalAmount=groupService.totalAmountSpentByUsers(groupId);
        return new ResponseEntity<>("Total Amount Spent by the group is "+totalAmount, HttpStatus.OK);
    }

}


