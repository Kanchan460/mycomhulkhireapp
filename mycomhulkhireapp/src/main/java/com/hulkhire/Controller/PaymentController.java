package com.hulkhire.Controller;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hulkhire.Pojo.Payments;
import com.hulkhire.Pojo.PaymentsRequest;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final Map<Long, Payments> payments = new HashMap<>();
    private long idCounter = 1;

    // Create Payment
    @PostMapping
    public ResponseEntity<Map<String, Object>> createPayment(@RequestBody PaymentsRequest request) {
        long id = idCounter++;
        Payments payment = new Payments(id, request.getPayerName(), request.getAmount(), request.getCurrency(),
                request.getPaymentMode(), request.getStatus(), request.getTimestamp(), request.getReceiver(),
                request.getReferenceId(), request.getRemarks(), request.getLocation());
        payments.put(id, payment);
        return ResponseEntity.ok(Collections.singletonMap("id", id));
    }

    // Get Payment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Payments> getPayment(@PathVariable Long id) {
        Payments payment = payments.get(id);
        if (payment == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(payment);
    }

    // Update Payment fully (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePayment(@PathVariable Long id, @RequestBody PaymentsRequest request) {
        if (!payments.containsKey(id)) return ResponseEntity.notFound().build();
        Payments updated = new Payments(id, request.getPayerName(), request.getAmount(), request.getCurrency(),
                request.getPaymentMode(), request.getStatus(), request.getTimestamp(), request.getReceiver(),
                request.getReferenceId(), request.getRemarks(), request.getLocation());
        payments.put(id, updated);
        return ResponseEntity.ok().build();
    }

    // Partial update (PATCH)
    @PatchMapping("/{id}")
    public ResponseEntity<?> patchPayment(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Payments payment = payments.get(id);
        if (payment == null) return ResponseEntity.notFound().build();

        updates.forEach((k, v) -> {
            switch (k) {
                case "payerName" -> payment.setPayerName((String) v);
                case "amount" -> payment.setAmount(Double.valueOf(v.toString()));
                case "currency" -> payment.setCurrency((String) v);
                case "paymentMode" -> payment.setPaymentMode((String) v);
                case "status" -> payment.setStatus((String) v);
                case "timestamp" -> payment.setTimestamp(LocalDateTime.parse((String) v));
                case "receiver" -> payment.setReceiver((String) v);
                case "referenceId" -> payment.setReferenceId((String) v);
                case "remarks" -> payment.setRemarks((String) v);
                case "location" -> payment.setLocation((String) v);
            }
        });

        return ResponseEntity.ok().build();
    }

    // Delete Payment
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable Long id) {
        if (!payments.containsKey(id)) return ResponseEntity.notFound().build();
        payments.remove(id);
        return ResponseEntity.ok().build();
    }

    // Repeat Payment
    @PostMapping("/{id}/repeat")
    public ResponseEntity<Map<String, Object>> repeatPayment(@PathVariable Long id) {
        Payments existing = payments.get(id);
        if (existing == null) return ResponseEntity.notFound().build();
        Payments copy = new Payments(idCounter++, existing.getPayerName(), existing.getAmount(), existing.getCurrency(),
                existing.getPaymentMode(), existing.getStatus(), LocalDateTime.now(), existing.getReceiver(),
                existing.getReferenceId(), existing.getRemarks(), existing.getLocation());
        payments.put(copy.getId(), copy);
        return ResponseEntity.ok(Collections.singletonMap("id", copy.getId()));
    }
}
