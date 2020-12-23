package use_case;

import model.Recruiter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.of;

public class FakeRecruiters implements RecruiterRepository {

    List<Recruiter> recruiters;

    @Override
    public List<Recruiter> getAllRecruiters() {
        return recruiters;
    }

    public FakeRecruiters() {
        recruiters = new ArrayList<>();

        List<String> emmaSkills = new ArrayList<>();
        emmaSkills.add("PHP");
        emmaSkills.add("JS");
        List<LocalDate> emmaAvailabilities = new ArrayList<>();
        emmaAvailabilities.add(of(2021, 2, 20));
        Recruiter emma = new Recruiter("001", "Emma", emmaSkills, emmaAvailabilities);
        recruiters.add(emma);

        List<String> marySkills = new ArrayList<>();
        marySkills.add("Java");
        marySkills.add(".Net");
        marySkills.add("PHP");
        marySkills.add("JS");
        List<LocalDate> maryAvailabilities = new ArrayList<>();
        maryAvailabilities.add(of(2021, 2, 20));
        maryAvailabilities.add(of(2021, 2, 22));
        Recruiter mary = new Recruiter("002", "Mary", marySkills, maryAvailabilities);
        recruiters.add(mary);

        List<String> johnSkills = new ArrayList<>();
        johnSkills.add("Java");
        johnSkills.add(".Net");
        johnSkills.add("PHP");
        johnSkills.add("JS");
        List<LocalDate> johnAvailabilities = new ArrayList<>();
        johnAvailabilities.add(of(2021, 2, 20));
        Recruiter john = new Recruiter("003", "John", johnSkills, johnAvailabilities);
        recruiters.add(john);
    }
}
