package com.dreams.hotline.controller;

import com.dreams.hotline.model.Client;
import com.dreams.hotline.model.DocumentClient;
import com.dreams.hotline.repository.ClientRepository;
import com.dreams.hotline.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    private final ClientRepository clientRepository;
    private final ClientService clientService;

    public ClientController(ClientRepository clientRepository, ClientService clientService) {
        this.clientRepository = clientRepository;
        this.clientService = clientService;
    }

    @GetMapping("/Dashboard")
    public String Dashboard(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        return "client/Dashboard";
    }

    @GetMapping("/view/{id}")
    public String ShowClient(@PathVariable("id") Long id, Model model) {
        Optional<Client> Client = clientService.getClientById(id);
        model.addAttribute("client", Client);
        return "client/view";
    }

    @GetMapping("/create")
    public String CreateClient(Model model) {
        model.addAttribute("client", new Client());
        return "client/create";
    }

    @PostMapping("save")
    public String SaveClient(@ModelAttribute("client") Client client,
                             BindingResult result,
                             RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            return "client/create";
        }

        clientService.saveClient(client);
        redirectAttributes.addFlashAttribute("success",
                client.getId() != null ? "DocumentClient mise à jour avec succès" : "DocumentClient sauvergardé avec succès");
        return "redirect:/view/" + client.getId();
    }

    @GetMapping("edit/{id}")
    public String EditClient(@PathVariable("id") Long id, Model model) {
        Optional<Client> Client = clientService.getClientById(id);
        model.addAttribute("client", Client);
        return "client/create";
    }
    @PostMapping("delete/{id}")
    public String DeleteClient(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        Boolean ClientExist = clientService.deleteClient(id);
        if(ClientExist) {
            redirectAttributes.addFlashAttribute("success", "Client supprimé avec succès");
        }
        else{
            redirectAttributes.addFlashAttribute("error", "Client non trouvés");
        }
        return "redirect:/Dashboard";
    }
}
