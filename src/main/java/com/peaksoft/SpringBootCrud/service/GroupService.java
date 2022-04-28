package com.peaksoft.SpringBootCrud.service;
import com.peaksoft.SpringBootCrud.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();
    void saveGroup(Group group);
    Group getGroupById(long id);
    void deleteGroupById(long id);
//    Group update(Group group);
}
