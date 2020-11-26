package use_case;

import model.Recruiter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.of;
import static java.util.stream.Collectors.toList;

public class FakeRecruiters implements RecruiterRepository {

    List<Recruiter> recruiters;

    public FakeRecruiters() {
        recruiters = new ArrayList<>();

        Recruiter emma = new Recruiter();
        List<String> emmaSkills = new ArrayList<>();
        emmaSkills.add("PHP");
        emmaSkills.add("JS");
        emma.setSkills(emmaSkills);
        emma.setName("Emma");
        List<LocalDate> emmaAvailabilities = new ArrayList<>();
        emmaAvailabilities.add(of(2021, 2, 20));
        emma.setAvailabilities(emmaAvailabilities);
        recruiters.add(emma);

        Recruiter mary = new Recruiter();
        List<String> marySkills = new ArrayList<>();
        marySkills.add("Java");
        marySkills.add(".Net");
        marySkills.add("PHP");
        marySkills.add("JS");
        mary.setSkills(marySkills);
        mary.setName("Mary");
        List<LocalDate> maryAvailabilities = new ArrayList<>();
        maryAvailabilities.add(of(2021, 2, 20));
        maryAvailabilities.add(of(2021, 2, 22));
        mary.setAvailabilities(maryAvailabilities);
        recruiters.add(mary);

        Recruiter john = new Recruiter();
        List<String> johnSkills = new ArrayList<>();
        johnSkills.add("Java");
        johnSkills.add(".Net");
        johnSkills.add("PHP");
        johnSkills.add("JS");
        john.setSkills(johnSkills);
        john.setName("John");
        List<LocalDate> johnAvailabilities = new ArrayList<>();
        johnAvailabilities.add(of(2021, 2, 20));
        john.setAvailabilities(johnAvailabilities);
        recruiters.add(john);
    }

    @Override
    public List<Recruiter> findRecruiterByAvailability(LocalDate availability) {
        return recruiters.stream()
                .filter(recruiter -> recruiter.getAvailabilities().contains(availability))
                .collect(toList());
    }
}
