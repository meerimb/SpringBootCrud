package com.peaksoft.SpringBootCrud.service;

import com.peaksoft.SpringBootCrud.model.Group;
import com.peaksoft.SpringBootCrud.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GroupServiceImpl implements GroupService{

    private final GroupRepository groupRepository;

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public void saveGroup(Group group) {
        this.groupRepository.save(group);
    }

    @Override
    public Group getGroupById(long id) {
        Optional< Group > optional = groupRepository.findById(id);
        Group group = null;
        if (optional.isPresent()) {
            group  = optional.get();
        } else {
            throw new RuntimeException(" Group not found for id :: " + id);
        }
        return group;
    }

    @Override
    public void deleteGroupById(long id) {
        this.groupRepository.deleteById(id);
    }

//    @Override
//    public Group update(Group group) {
//        groupRepository.save(group);
//        return group;
//
//    }
}
