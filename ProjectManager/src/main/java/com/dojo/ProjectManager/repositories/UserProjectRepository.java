package com.dojo.ProjectManager.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;
import com.dojo.ProjectManager.models.UserProject;

@Repository
public interface UserProjectRepository extends CrudRepository<UserProject,Long>
{
	List<UserProject> findByUserId(Long user_id);
	
	List<UserProject> findByUserIdNot(Long user_id);

}
