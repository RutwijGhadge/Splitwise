package com.project.Splitwise.Controller;
import com.project.Splitwise.Service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController  {
    @Autowired
    private GroupService groupService;



}
//GET,PUT,POST,DELETE,PATCH