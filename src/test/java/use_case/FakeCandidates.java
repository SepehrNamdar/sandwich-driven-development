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

        List<String> alexSkills = new ArrayList<>();
        alexSkills.add(".Net");
        alexSkills.add("Java");
        alexSkills.add("PHP");
        alexSkills.add("JS");
        Candidate alex = new Candidate(alexSkills, "Alex");
        candidates.put("123", alex);

        List<String> bobSkills = new ArrayList<>();
        bobSkills.add("JS");
        Candidate bob = new Candidate(bobSkills, "Bob");
        candidates.put("456", bob);

        List<String> kimSkills = new ArrayList<>();
        kimSkills.add("Ruby");
        Candidate kim = new Candidate(kimSkills, "Kim");
        candidates.put("789", kim);
    }

    @Override
    public Candidate findById(String candidateId) {
        return candidates.get(candidateId);
    }
}
