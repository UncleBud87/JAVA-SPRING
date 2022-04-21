package com.dojo.ProjectManager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.ProjectManager.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task,Long>
{

}
