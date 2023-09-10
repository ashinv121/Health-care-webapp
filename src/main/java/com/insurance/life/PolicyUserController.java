package com.insurance.life;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PolicyUserController {
	
	@Autowired
	PolicyUserRepository policyUserRepository;
	
	@Autowired
	PolicyUserService policyUserService;
	
	@GetMapping("/helloworld")
	public String sayHelloWorld() {
		
		return "Hello world from Sprint boot";
	}
	
	@PostMapping("/createPolicy")
	public PolicyUser createPolicy(@RequestBody PolicyUser newpolicy ) {
		
		
		PolicyUser savedPolicy=policyUserService.createNewPolicy(newpolicy);
		
		if(savedPolicy!=null) {
			
			return savedPolicy;
					/*"login has been successfully registered";*/
		
		}
		
		else {
			return null;
		}

	}
	

	@GetMapping("/viewPolicy/{policyId}")
	public PolicyUser viewPolicy(@PathVariable Long policyId ) {
		
		PolicyUser policyUser =policyUserService.getPolicyUser(policyId);
		
		if(policyUser!=null) {
			
			return policyUser;
		
		}
		
		else {
			return null;
		}
		
	}
	
//	@PutMapping("/update/")	
//	public String modifiedPolicy(@RequestBody PolicyUser updateUser){
//		
//		String policyUser =policyUserService.updatePolicyuser(updateUser);
//		
//		if(policyUser!=null) {
//			
//			return "sucess";
//		
//		}
//		
//		else {
//			return null;
//		}
//	
//	}
	
	
	@PutMapping("/update/")
	public ResponseEntity<String> modifiedPolicy(@RequestBody PolicyUser updateUser) {
	    try {
	        // Check if the policy exists in the database
	        Optional<PolicyUser> existingPolicy = policyUserRepository.findById(updateUser.getPolicy_id());
	        if (existingPolicy.isPresent()) {
	            PolicyUser policyUser = existingPolicy.get();
	            policyUser.setContactNo(updateUser.getContactNo());
	            policyUser.setName(updateUser.getName());
	            policyUser.setAge(updateUser.getAge());
	            policyUserRepository.save(policyUser);

	            return ResponseEntity.ok("Policy updated successfully.");
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

	
	
	@DeleteMapping("/deletePolicy/{policyId}")
	public void deletePolicy(@PathVariable Long policyId ) {
		
		policyUserService.deletePolicyUser(policyId);
		
		
	
	}	
}
	
	
	
	