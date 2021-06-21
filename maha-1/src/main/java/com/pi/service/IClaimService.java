package com.pi.service;

import java.util.List;

import com.pi.entities.Claim;

public interface IClaimService {
	
	public Claim addClaim(Claim Claim);
	public List<Claim> listClaim();
	public Claim updateClaim(Claim Claim);
	public void deleteClaimById(Long idCl);
	public Claim getClaimById(long idCl);

}
