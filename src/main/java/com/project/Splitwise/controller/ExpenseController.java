package com.project.Splitwise.controller;

import com.project.Splitwise.DTO.ExpenseDTO;
import com.project.Splitwise.Exception.GroupNotFoundException;
import com.project.Splitwise.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    //creating a new expense for a group
    @PostMapping("/{groupId}/create-expense")
    public ResponseEntity createExpenseForGroup(@PathVariable int groupId, @RequestBody ExpenseDTO expenseDTO) throws GroupNotFoundException {
        return new ResponseEntity<>(expenseService.createExpenseForGroup(groupId,expenseDTO), HttpStatus.CREATED);
    }
}
