package com.example.orders.facades;

import com.example.orders.dtos.ReceiptResponseDTO;
import reactor.core.publisher.Mono;

public interface ReceiptFacade {

    Mono<ReceiptResponseDTO> retrieveReceipt(String orderId);
}
