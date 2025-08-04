package edu.sliit.service.impl;


import edu.sliit.datastructure.UserQueue;
import edu.sliit.dto.User;
import edu.sliit.entity.UserEntity;
import edu.sliit.repository.UserRepository;
import edu.sliit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<User> getAll() {
        UserQueue queue = new UserQueue();

        // Load all agents from DB and enqueue them
        for (UserEntity entity : repository.findAll()) {
            User user = mapper.map(entity, User.class);
            queue.enqueue(user);
        }

        // Sort the queue by date using insertion sort
        queue.sortByDate();

        // Get sorted agents as List
        return queue.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        System.out.println(user);
        repository.save(mapper.map(user, UserEntity.class));
    }

    @Override
    public void deleteUserById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public User searchUserById(Integer id) {
        return mapper.map(repository.findById(id),User.class);


    }

    @Override
    public void updateUserById(User user) {
        repository.save(mapper.map(user, UserEntity.class));
    }
}
