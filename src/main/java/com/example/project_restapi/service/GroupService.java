package com.example.project_restapi.service;


import com.example.project_restapi.DTO.group.GroupRequest;
import com.example.project_restapi.DTO.group.GroupResponse;

import java.io.IOException;
import java.util.List;

public interface GroupService {
    List<GroupResponse> getAllGroup(Long id);

    List<GroupResponse> getAllGroupsByCourseId(Long courseId);

    GroupResponse addGroupByCourseId(Long id, Long courseId, GroupRequest groupRequest);

    GroupResponse addGroup(Long id, GroupRequest groupRequest);

    GroupResponse getGroupById(Long id);

    GroupResponse updateGroup(GroupRequest groupRequest, Long id);

    GroupResponse deleteGroup(Long id);

    void assignGroup(Long courseId, Long groupId) throws IOException;
}
