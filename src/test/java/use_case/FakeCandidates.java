package use_case;

import model.Candidate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeCandidates implements CandidateRepository {

    Map<String, Candidate> candidates;

    @Override
    public Candidate findById(String candidateId) {
        return candidates.get(candidateId);
    }

    public FakeCandidates() {
        candidates = new HashMap<>();

        List<String> alexSkills = new ArrayList<>();
        alexSkills.add(".Net");
        alexSkills.add("Java");
        alexSkills.add("PHP");
        alexSkills.add("JS");
        Candidate alex = new Candidate("Alex", alexSkills);
        candidates.put("123", alex);

        List<String> bobSkills = new ArrayList<>();
        bobSkills.add("JS");
        Candidate bob = new Candidate("Bob", bobSkills);
        candidates.put("456", bob);

        List<String> kimSkills = new ArrayList<>();
        kimSkills.add("Ruby");
        Candidate kim = new Candidate("Kim", kimSkills);
        candidates.put("789", kim);
    }
}
