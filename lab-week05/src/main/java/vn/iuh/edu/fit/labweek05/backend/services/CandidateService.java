package vn.iuh.edu.fit.labweek05.backend.services;

import org.springframework.stereotype.Service;
import vn.iuh.edu.fit.labweek05.frontend.models.Candidate;

import java.util.List;
import java.util.Optional;

@Service
public interface CandidateService {
    List<Candidate> findAll();
    Optional<Candidate> findById(Long id);
    Candidate save(long id, Candidate candidate);
    void delete(Long id);
}
