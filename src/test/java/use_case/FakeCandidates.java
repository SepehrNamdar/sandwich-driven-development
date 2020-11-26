package use_case;

import model.Candidate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeCandidates implements CandidateRepository {

    Map<String, Candidate> candidates;

    public FakeCandidates() {
        candidates = new HashMap<>();

        Candidate alex = new Candidate();
        List<String> alexSkills = new ArrayList<>();
        alexSkills.add(".Net");
        alexSkills.add("Java");
        alexSkills.add("PHP");
        alexSkills.add("JS");
        alex.setSkills(alexSkills);
        alex.setName("Alex");
        candidates.put("123", alex);

        Candidate bob = new Candidate();
        List<String> bobSkills = new ArrayList<>();
        bobSkills.add("JS");
        bob.setSkills(bobSkills);
        bob.setName("Bob");
        candidates.put("456", bob);

        Candidate kim = new Candidate();
        List<String> kimSkills = new ArrayList<>();
        kimSkills.add("Ruby");
        kim.setSkills(kimSkills);
        kim.setName("Kim");
        candidates.put("789", kim);
    }

    @Override
    public Candidate findById(String candidateId) {
        return candidates.get(candidateId);
    }
}
