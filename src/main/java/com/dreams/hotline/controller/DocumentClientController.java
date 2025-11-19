package com.dreams.hotline.controller;

import com.dreams.hotline.model.DocumentClient;
import com.dreams.hotline.repository.DocumentClientRepository;
import com.dreams.hotline.service.DocumentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/")
public class DocumentClientController {

    @Autowired
    public final DocumentClientService documentClientService;

    public DocumentClientController(DocumentClientService documentClientService) {
        this.documentClientService = documentClientService;
    }

    @GetMapping("/Dashboard")
    public String Dashboard(Model model) {
        List<DocumentClient> DocumentClients = documentClientService.getAllDocumentClients();
        model.addAttribute("DocmumentClients", DocumentClients);
        return "DocumentClient/index";
    }

    @GetMapping("/view/{id}")
    public String ShowDocumentClient(@PathVariable("id") Long id, Model model) {
        Optional<DocumentClient> documentClient = documentClientService.getDocumentClientById(id);
        model.addAttribute("DocmumentClient", documentClient.get());
        return "DocumentClient/view";
    }

    @PostMapping("/create")
    public String CreateDocumentClient(Model model) {
        model.addAttribute("DocmumentClient", new DocumentClient());
        return "DocumentClient/create";
    }

    @PostMapping("/save")
    public String SaveDocumentClient(@ModelAttribute("DocumentClient") DocumentClient documentClient,
                                     BindingResult result,
                                     RedirectAttributes redirectAttributes) {
        if(result.hasErrors()){
            return "DocumentClient/create";
        }

        documentClientService.saveDocumentClient(documentClient);
        redirectAttributes.addFlashAttribute("success",
                documentClient.getId() != null ? "DocumentClient mise à jour avec succès" : "DocumentClient sauvergardé avec succès");
        return "redirect:/Dashboard";
    }
    @GetMapping("/edit/{id}")
    public String EditDocumentClient(@PathVariable("id") Long id, Model model){
        Optional<DocumentClient> documentClient =  documentClientService.getDocumentClientById(id);
        model.addAttribute("DocmumentClient", documentClient.get());
        return "DocumentClient/create";
    }

    @PostMapping("/delete/{id}")
    public String DeleteDocumentClient(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        Boolean DocumentClientExist = documentClientService.deleteDocumentClient(id);
        if(DocumentClientExist) {
            redirectAttributes.addFlashAttribute("success", "DocumentClient supprimé avec succès");
        }
        else {
            redirectAttributes.addFlashAttribute("error", "DocumentClient non trouvés");
        }
        return "redirect:/Dashboard";
    }
}
