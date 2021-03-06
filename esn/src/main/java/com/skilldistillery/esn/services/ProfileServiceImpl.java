package com.skilldistillery.esn.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.esn.entities.Game;
import com.skilldistillery.esn.entities.Organization;
import com.skilldistillery.esn.entities.Player;
import com.skilldistillery.esn.entities.Profile;
import com.skilldistillery.esn.entities.Team;
import com.skilldistillery.esn.entities.User;
import com.skilldistillery.esn.enums.Role;
import com.skilldistillery.esn.repositories.PlayerRepo;
import com.skilldistillery.esn.repositories.ProfileRepo;
import com.skilldistillery.esn.repositories.TeamRepo;
import com.skilldistillery.esn.repositories.UserRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepo profileRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PlayerRepo playerRepo;
	@Autowired
	private TeamRepo teamRepo;

	@Override
	public List<Profile> index(String username) {
		if (userRepo.findByUsername(username).getRole().equals(Role.Admin)) {
			return profileRepo.findAll();
		} else {
			return profileRepo.findAllByUser_Username(username);
		}
	}

	@Override
	public Profile show(Integer pid) {
		Optional<Profile> opt = profileRepo.findById(pid);
		
		if (opt.isPresent()) {
			Profile profile = opt.get();
			return profile;
		}
		return null;
	}
	
	@Override
	public Profile getByUsername(String username) {
		return profileRepo.findByUser_Username(username);
	}

	@Override
	public Profile create(Profile profile, String username) {
		try {
			User user = userRepo.findByUsername(username);
			if (user != null) {
				profile.setUser(user);
				return profileRepo.saveAndFlush(profile);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public Profile update(String username, Profile profile) {
		Profile managedProfile = profileRepo.findByUser_Username(username);
		
		if (managedProfile != null) {
			if (!profile.getAvatar().equals("")) {
				managedProfile.setAvatar(profile.getAvatar());				
			}
			if (!profile.getEmail().equals("")) {
				managedProfile.setEmail(profile.getEmail());
			}
			if (!profile.getFirstName().equals("")) {
				managedProfile.setFirstName(profile.getFirstName());
			}
			if (!profile.getLastName().equals("")) {
				managedProfile.setLastName(profile.getLastName());
			}

			return profileRepo.saveAndFlush(managedProfile);
		}

		return null;
	}

	@Override
	public Profile addTeam(String username, Team team) {
		Optional<Team> optionalTeam = teamRepo.findById(team.getId());
		Profile profile = profileRepo.findByUser_Username(username);

		if (profile != null && optionalTeam.isPresent()) {
			profile.addTeam(optionalTeam.get());
			return profileRepo.saveAndFlush(profile);
		}
		return null;
	}

	@Override
	public Profile addPlayer(String username, Player player) {
		Optional<Player> optionalPlayer = playerRepo.findById(player.getId());
		Profile profile = profileRepo.findByUser_Username(username);

		if (profile != null && optionalPlayer.isPresent()) {
			profile.addPlayer(optionalPlayer.get());
			return profileRepo.saveAndFlush(profile);
		}
		return null;
	}

	@Override
	public Profile addOrg(String username, Organization organization) {
		Profile profile = profileRepo.findByUser_Username(username);
		
		if(profile != null) {
			profile.addOrganization(organization);
			return profileRepo.saveAndFlush(profile);
		}
		return null;
	}

	@Override
	public Profile addGame(String username, Game game) {
		Profile profile = profileRepo.findByUser_Username(username);
		
		if(profile != null) {
			profile.addGame(game);
			return profileRepo.saveAndFlush(profile);
		}
		return null;
	}

	@Override
	public Profile removeTeam(String username, Team team) {
		Profile profile = profileRepo.findByUser_Username(username);
		
		if (profile != null) {
			profile.removeTeam(team);
			return profileRepo.saveAndFlush(profile);
		}
		return null;
	}

	@Override
	public Profile removePlayer(String username, Player player) {
	Profile profile = profileRepo.findByUser_Username(username);
		
		if (profile != null) {
			profile.removePlayer(player);
			return profile;
		}
		return null;
	}

	@Override
	public Profile removeOrg(String username, Organization organization) {
	Profile profile = profileRepo.findByUser_Username(username);
		
		if (profile != null) {
			profile.removeOrganization(organization);
			return profileRepo.saveAndFlush(profile);
		}
		return null;
	}

	@Override
	public Profile removeGame(String username, Game game) {
	Profile profile = profileRepo.findByUser_Username(username);
		
		if (profile != null) {
			profile.removeGame(game);
			return profileRepo.saveAndFlush(profile);
		}
		return null;
	}

}
