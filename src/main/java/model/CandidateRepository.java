package model;

import model.Candidate;

public interface CandidateRepository {
    Candidate findById(String candidateId);
}
