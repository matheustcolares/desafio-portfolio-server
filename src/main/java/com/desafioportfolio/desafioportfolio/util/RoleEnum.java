package com.desafioportfolio.desafioportfolio.util;

public enum RoleEnum {
	Stundent(1),Professor(2),Coordinator(3),Administrator(4);
	
	private final int role;
	
	RoleEnum(int optionRole) {
		role = optionRole;
	}

	public int getRole() {
		return role;
	}

}
