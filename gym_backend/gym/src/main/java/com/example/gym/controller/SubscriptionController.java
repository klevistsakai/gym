package com.example.gym.controller;

import com.example.gym.models.SubscriptionEntity;
import com.example.gym.service.SubscriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Annotation
@RestController
@CrossOrigin(origins = "http://localhost:3000")

// Class
@RequestMapping("/api")

public class SubscriptionController {

    // Annotation
    @Autowired private SubscriptionService subscriptionService;

    // Save operation
    @PostMapping("/subscriptions/save")
    public SubscriptionEntity saveSubscription(
            @Valid @RequestBody SubscriptionEntity subscription)
    {

        return subscriptionService.saveSubscription(subscription);
    }

    // Read operation
    @GetMapping("/subscriptions")
    public List<SubscriptionEntity> fetchSubscriptionList()
    {

        return subscriptionService.fetchSubscriptionList();
    }
    @GetMapping("/subscriptions/{id}")
    public Optional<SubscriptionEntity> fetchSubscriptionId(@PathVariable("id") Long subscriptionId)
    {

        return subscriptionService.fetchSubscriptionId(subscriptionId);
    }


    // Update operation
    @PutMapping("/subscriptions/update/{id}")
    public SubscriptionEntity
    updateSubscription(@RequestBody SubscriptionEntity subscription,
                       @PathVariable("id") Long subscriptionId)
    {

        return subscriptionService.updateSubscription(
                subscription, subscriptionId);
    }

    // Delete operation
    @DeleteMapping("/subscriptions/delete/{id}")
    public String deleteSubscriptionById(@PathVariable("id")
                                                 Long subscriptionId)
    {

        subscriptionService.deleteSubscriptionById(
                subscriptionId);
        return "Deleted Successfully";
    }
}