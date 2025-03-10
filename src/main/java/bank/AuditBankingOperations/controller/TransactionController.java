package bank.AuditBankingOperations.controller;


import bank.AuditBankingOperations.dto.request.TransactionRequestDTO;
import bank.AuditBankingOperations.dto.response.TransactionResponseDTO;
import bank.AuditBankingOperations.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TransactionResponseDTO> postTransaction(@Validated @RequestBody TransactionRequestDTO transaction){
        return transactionService.saveTransaction(transaction);
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<TransactionResponseDTO> streamTransaction(@RequestParam String customerId){
        return transactionService.streamTransaction(customerId);
    }
}
