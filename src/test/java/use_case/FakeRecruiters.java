package use_case;

import model.Recruiter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.of;

public class FakeRecruiters implements RecruiterRepository {

    private final List<Recruiter> recruiters;

    @Override
    public List<Recruiter> findAllRecruiters() {
        return recruiters;
    }

    @Override
    public Recruiter updateRecruiter(Recruiter recruiter) {
        // update this recruiter
        return recruiter;
    }

    public FakeRecruiters() {
        recruiters = new ArrayList<>();

        List<String> emmaSkills = new ArrayList<>();
        emmaSkills.add("PHP");
        emmaSkills.add("JS");
        List<LocalDate> emmaAvailabilities = new ArrayList<>();
        emmaAvailabilities.add(of(2021, 2, 20));
        Recruiter emma = new Recruiter("001", emmaSkills, emmaAvailabilities, "Emma");
        recruiters.add(emma);

        List<String> marySkills = new ArrayList<>();
        marySkills.add("Java");
        marySkills.add(".Net");
        marySkills.add("PHP");
        marySkills.add("JS");
        List<LocalDate> maryAvailabilities = new ArrayList<>();
        maryAvailabilities.add(of(2021, 2, 20));
        maryAvailabilities.add(of(2021, 2, 22));
        Recruiter mary = new Recruiter("002", marySkills, maryAvailabilities, "Mary");
        recruiters.add(mary);

        List<String> johnSkills = new ArrayList<>();
        johnSkills.add("Java");
        johnSkills.add(".Net");
        johnSkills.add("PHP");
        johnSkills.add("JS");
        List<LocalDate> johnAvailabilities = new ArrayList<>();
        johnAvailabilities.add(of(2021, 2, 20));
        Recruiter john = new Recruiter("003", johnSkills, johnAvailabilities, "John");
        recruiters.add(john);
    }
}
