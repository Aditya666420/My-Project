package com.voting.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voting.test.enums.Inputs;
import com.voting.test.enums.VoteIn;
import com.voting.test.model.Constituency;
import com.voting.test.model.Count;
import com.voting.test.model.ElectionSchedule;
import com.voting.test.model.Map1;
import com.voting.test.model.Parties;
import com.voting.test.model.Voters;
import com.voting.test.service.CastingDao;
import com.voting.test.service.ConstiDao;
import com.voting.test.service.ElectionDao;
import com.voting.test.service.MapDao;
import com.voting.test.service.PartyDao;
import com.voting.test.service.VoterDao;
import com.voting.test.service.Voting;

@RestController
public class Controller {
	
	@Autowired
	VoterDao vd;
	@Autowired
	PartyDao pd;
	@Autowired
	ConstiDao consti;
	@Autowired
	ElectionDao ed;
	@Autowired
	MapDao md;
	@Autowired
	static
	CastingDao co; 
	
	
	@PostMapping("/voter")
	public String saveVoter(@RequestBody Voters v) {
		if(vd.ageValidation(v.getAge())) {
			vd.insert(v);
			return "Successfully Added";
		}
		return "Age should be greater than 18";
		
	}
	@GetMapping("/voter_list/{id}")
	public Voters getOne(@PathVariable int id) {
		Voters v = VoterDao.getById(id);
		return v;
	}
	@GetMapping("/getAll")
	public List<Voters> getAll(){
		List<Voters> c=vd.getAll();
		return c;
	}
	@DeleteMapping("/voter_list_remove/{id}")
	public String delete(@PathVariable int id) {
		if(vd.deleteById(id)) {
			return "Success";
		}
		return "Fail";
	}
	@PutMapping("/voter_list_update/{id}/{name}")
	public String updateName(@PathVariable int id,@PathVariable String name) {
		if(VoterDao.update(id, name)) {
			return "Success";
		}
		return "failure";
	}
	
	
	
	
	//Parties
	@PostMapping("/party")
	public String enterP(@RequestBody Parties p) {
		List<Parties> li=pd.getAllParty();
		for(Parties k:li) {
			if(k.getId()==p.getId() && k.getPartyname()== p.getPartyname()) {
				return "Already exists with same details";
			}
			if(k.getId()==p.getId()) {
				return "Already exist with same id ";
			}
			if(k.getPartyname().equals(p.getPartyname())) {
				return "Give different name";
			}
		}
		pd.insertParty(p);
		return "Successfully Added";
		
	}
	@GetMapping("/party_list/")
	public List<Parties> getAllP() {
		List<Parties> li = pd.getAllParty();
		return li;
	}
	@GetMapping("/party_list/{id}")
	public Parties getP(@PathVariable int id) {
		Parties p=pd.getById(id);
		return p;
		
	}
	@DeleteMapping("/party_list/delete/{id}")
	public String delP(@PathVariable int id) {
		List<Parties> li = pd.getAllParty();
		for(Parties k : li) {
			if(k.getId()== id) {
				pd.deleteById(id);
				return "Deleted";
			}
		}
		return "Not Present";
	}
	@PutMapping("party_list_update/{id}/{name}")
	public String partyEdit(@PathVariable int id,@PathVariable String name) {
		if(pd.getById(id)!= null) {
			if(pd.update(id, name)) {
				
			return "Successfully Updated";
			}
			else {
				return "Failed";
			}
		}
		
			return "Not present";
		
		
	}
	
	
	
	
	
	
	
	
	//Constituency
	@PostMapping("/constituency")
	public String enterC(@RequestBody Constituency c) {
		List<Constituency> li = consti.getAllCons();
		
		for(Constituency k:li) {
			if(k.getConstituency_id()==c.getConstituency_id()) {
				return "Already exists";
			}
		}
		consti.insertConsti(c);
		return "Successfully added";
	}
	@GetMapping("/constituency_list/")
	public List<Constituency> getAllthe(){
		List<Constituency> li = consti.getAllCons();
		return li;
	}
	
	@GetMapping("/constituency_list/{id}")
	public Constituency constiID(@PathVariable int id) {
		Constituency c = consti.getById(id);
		return c;
	}
	@DeleteMapping("/constituency_list/delete/{id}")
	public String deleteConstiById(@PathVariable int id) {
		List<Constituency> li = consti.getAllCons();
		int c=0;
		for(Constituency k : li) {
			if(k.getConstituency_id()== id) {
				c=1;
				break;
			}
		}
		if(c==1) {
			consti.deleteById(id);
			return "Sucess";
		}
		return "Not present";	
	}
	@PutMapping("/constituency_list_update/{id}/{name}")
	public String updateConsti(@PathVariable int id, @PathVariable String name ) {
		if(consti.update(id, name)) {
			return "Sucess";
		}
		return "Failed";
	}
	
	
	//Election_schedule
	@PostMapping("/election_schedule")
	public String addS( @RequestBody ElectionSchedule e) {
		if(!ed.isValidDate(e.getDate())) {
			return "Enter valid Date";
		}
		List<ElectionSchedule> li = ed.getAllS();
		for(ElectionSchedule k:li) {
			if(k.getElection_id()==e.getElection_id()) {
				return "Same id exists";
			}
		}
		if(ed.insertEs(e)) {
			return "Successfully Added";
		}
		return "Failed";
	}
	
	@GetMapping("/election_schedule_list/")
	public List<ElectionSchedule> getAllE() {
		List<ElectionSchedule> li = ed.getAllS();
		return li;
	}
	
	@GetMapping("/election_schedule_list/{id}")
	public ElectionSchedule getDate(@PathVariable int id) {
		ElectionSchedule e = ed.getEsById(id);
		return e;
	}
	
	@DeleteMapping("election_schedule_list/delete/{id}")
	public String del(@PathVariable int id) {
			List<ElectionSchedule> li = ed.getAllS();
			int c =0;
			for(ElectionSchedule k : li) {
				if(k.getElection_id()==id) {
					c=1;
					break;
				}
			}
			if(c==1) {
				ed.deleteID(id);
				return "Successfully";
			}
			return "No existence";
	}
	@PutMapping("/election_schedule_update/{id}")
	public String upt(@PathVariable int id, @RequestBody Inputs i) {
		if(!ed.isValidDate(i.getDate())) {
			return "Enter valid date";
		}
		List<ElectionSchedule> li = ed.getAllS();
		for(ElectionSchedule k:li) {
			if(k.getElection_id()==id) {
				ed.updateDate(id, i.getDate());
				return "Success";
			}
		}
		return "Doesnot exist";
	}
	
	
	@GetMapping("/parties/{vid}")
	public List<Map1> getCount(@PathVariable int vid){
		List<Map1> li = md.getVbyCid(vid);
		return li;
	}
	@PostMapping("/cast_vote/{eid}")
	public static String voteParty(@RequestBody VoteIn vi,@PathVariable int eid ) {
		boolean k = co.castVote(eid,vi.getVid(), vi.getPid());
		if(k==true) {
			return "Voted..";
		}
		return "Failed...";
	}
	@GetMapping("/vote_result/{cid}")
	public static String getVoting(@PathVariable int cid){
		
		String s = co.winnerByEid(cid);
		return s;
		
	}
	

}
