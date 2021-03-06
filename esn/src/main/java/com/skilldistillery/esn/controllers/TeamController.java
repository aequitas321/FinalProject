package com.skilldistillery.esn.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.esn.entities.SeriesMatch;
import com.skilldistillery.esn.entities.Team;
import com.skilldistillery.esn.services.TeamService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http:localhost:4209" })
public class TeamController {

	@Autowired
	private TeamService teamSvc;

	@GetMapping("teams")
	public List<Team> index(HttpServletResponse res) {
		List<Team> results;
		try {
			results = teamSvc.index();
			if (results.size() > 0) {
				res.setStatus(200);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			results = null;
		}

		return results;
	}

	@GetMapping("teams/org/{oid}")
	public List<Team> getTeamsByOrg(@PathVariable Integer oid, HttpServletResponse res) {
		List<Team> results;
		try {
			results = teamSvc.getTeamsByOrg(oid);
			if (results.size() > 0) {
				res.setStatus(200);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			results = null;
		}

		return results;
	}

	@GetMapping("teams/region/{rid}")
	public List<Team> getTeamsByRegion(@PathVariable Integer rid, HttpServletResponse res) {
		List<Team> results;
		try {
			results = teamSvc.getTeamsByRegion(rid);
			if (results.size() > 0) {
				res.setStatus(200);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			results = null;
		}

		return results;
	}

	@GetMapping("teams/{tid}")
	public Team show(@PathVariable Integer tid, HttpServletResponse res) {
		Team result;
		try {
			result = teamSvc.show(tid);
			if (result != null) {
				res.setStatus(200);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			result = null;
		}

		return result;
	}

	@GetMapping("teams/{tid}/matches")
	public List<SeriesMatch> getMatchesByTeamId(@PathVariable Integer tid, HttpServletResponse res) {
		
		List<SeriesMatch> result;
		
		try {
			result = teamSvc.getMatchesByTeamId(tid);
			if (result != null) {
				res.setStatus(200);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			result = null;
		}
		
		return result;
	}
	
	@GetMapping("teams/favorites/matches")
	public List<SeriesMatch> getFavoriteTeamsMatches(
			@RequestBody Team[] teams,
			HttpServletResponse res)
	{
		System.out.println("\n\n\n"+teams+"\n\n\n");
		
		List<SeriesMatch> results;
		
		try {
			results = teamSvc.getMatchesByFavTeams(teams);
			if (results != null) {
				res.setStatus(200);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			results = null;
		}
		
		return results;
	}
	
}
