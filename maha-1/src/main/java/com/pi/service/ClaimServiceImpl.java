package com.pi.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pi.entities.Claim;
import com.pi.repository.ClaimRepository;

@Service
public class ClaimServiceImpl implements IClaimService {

	@Autowired
	ClaimRepository ClaimRep;
	
	public Claim addClaim(Claim Claim){
		ClaimRep.save(Claim);
		return Claim;
	}
	
	public List<Claim> listClaim(){
		return (List<Claim>) ClaimRep.findAll();
	}
	
	public Claim updateClaim(Claim Claim){
		ClaimRep.save(Claim);
		return Claim;
	}
	
	public void deleteClaimById(Long idCl){
		Claim claimManagementEntity=ClaimRep.findById((long) idCl).get();
		ClaimRep.delete(claimManagementEntity);
	}
	
	public Claim getClaimById(long idCl){
		Claim Claim = ClaimRep.findById((long) idCl).get();
		return Claim;
	}
	
	
}
