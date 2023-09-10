package com.insurance.life;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class PolicyUserService {
	
	@Autowired
	PolicyUserRepository policyUserRepository;	
	
	
	public PolicyUser createNewPolicy(PolicyUser newPolicy) {
			
		PolicyUser savedPolicy=policyUserRepository.save(newPolicy);
		return savedPolicy;
	}
	
	
	public String deletePolicyUser(Long policyid){
		
		
		policyUserRepository.deleteById(policyid);
		
		return "delete sucesess";
		
	}
	
//	public String updatePolicyuser(PolicyUser modifieduser ){
//		
//		
//		PolicyUser policyUser=policyUserRepository.findById(modifieduser.getPolicy_id()).get();
//		policyUser.setContactNo(modifieduser.getContactNo());
//		policyUser.setName(modifieduser.getName());
//		policyUser.setAge(modifieduser.getAge());
//		policyUser = policyUserRepository.save(policyUser);
//		return null;
//		
//	}
	public PolicyUser getPolicyUser(Long policyid){
		
		
		PolicyUser policyUser = policyUserRepository.findById(policyid).get();
		
		return policyUser;
	}
	
}
	