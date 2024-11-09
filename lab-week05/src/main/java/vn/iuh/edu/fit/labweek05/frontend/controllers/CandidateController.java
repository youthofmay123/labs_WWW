package vn.iuh.edu.fit.labweek05.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.iuh.edu.fit.labweek05.backend.repositories.AddressRepository;
import vn.iuh.edu.fit.labweek05.backend.repositories.CandidateRepository;
import vn.iuh.edu.fit.labweek05.backend.services.AddressServices;
import vn.iuh.edu.fit.labweek05.backend.services.CandidateService;
import vn.iuh.edu.fit.labweek05.frontend.models.Address;
import vn.iuh.edu.fit.labweek05.frontend.models.Candidate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CandidateService candidateService;

    @GetMapping("")
    public String showCandidateList(Model model){
        model.addAttribute("candidates", candidateService.findAll());
        return "candidate/list";
    }

    @GetMapping("/edit/{id}")
    public String showCandidateItem(@PathVariable Long id, Model model){
        Candidate candidate = candidateService.findById(id).orElse(null);
        if(candidate != null){
            // Định dạng `dob` thành chuỗi 'YYYY-MM-DD' nếu `dob` tồn tại
            LocalDate dob = candidate.getDob();
            String formatDob = dob != null ? dob.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : "";

            model.addAttribute("candidate", candidateService.findById(id).get());
            model.addAttribute("date", formatDob);

        }
        return "candidate/update";
    }



    @PostMapping("/edit/{id}")
    public String updateCandidate(@PathVariable Long id, @ModelAttribute("candidate") Candidate candidate){
        Candidate existingCandidate = candidateService.findById(id).orElse(null);
        if (existingCandidate != null) {
            // Cập nhật thông tin
            existingCandidate.setFullName(candidate.getFullName());
            existingCandidate.setDob(candidate.getDob());

            System.out.println(candidate.getAddress().getId());

            existingCandidate.setPhone(candidate.getPhone());
            existingCandidate.setEmail(candidate.getEmail());

            // Lưu lại thay đổi vào database
            System.out.println(existingCandidate);

            candidateService.save(id,existingCandidate);
        }

        return "redirect:/candidate";  // Nếu không tìm thấy ứng viên, chuyển hướng về danh sách
    }

}
