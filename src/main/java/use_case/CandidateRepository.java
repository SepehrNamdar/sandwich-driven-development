package use_case;

import model.Candidate;

public interface CandidateRepository {
    Candidate findById(String candidateId);
}
