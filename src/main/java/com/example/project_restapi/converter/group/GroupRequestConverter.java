package com.example.project_restapi.converter.group;

import com.example.project_restapi.DTO.group.GroupRequest;
import com.example.project_restapi.entities.Group;
import org.springframework.stereotype.Component;

@Component
public class GroupRequestConverter {
    public Group createGroup(GroupRequest groupRequest){
        if (groupRequest == null){
            return null;
        }

        Group group = new Group();

        group.setGroupName(groupRequest.getGroupName());
        group.setImage(groupRequest.getImage());
        group.setDateOfStart(groupRequest.getDateOfStart());

        return group;
    }


    public void updateGroup(Group group, GroupRequest groupRequest){
        if (groupRequest.getGroupName() != null){
            group.setGroupName(groupRequest.getGroupName());
        }if (groupRequest.getDateOfStart() != null){
           group.setDateOfStart(groupRequest.getDateOfStart());
        }if (groupRequest.getImage() != null){
            group.setImage(groupRequest.getImage());
        }
    }
}
