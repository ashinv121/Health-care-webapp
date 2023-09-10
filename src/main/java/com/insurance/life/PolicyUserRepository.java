package com.insurance.life;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyUserRepository extends CrudRepository<PolicyUser, Long>{

}
