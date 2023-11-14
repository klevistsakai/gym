package com.example.gym.service;

import com.example.gym.models.SubscriptionEntity;
import com.example.gym.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    // save operation
    @Override
    public SubscriptionEntity saveSubscription(SubscriptionEntity subscription) {
        return subscriptionRepository.save(subscription);
    }

    // read operation
    @Override
    public List<SubscriptionEntity> fetchSubscriptionList() {
        return (List<SubscriptionEntity>) subscriptionRepository.findAll();
    }

    @Override
    public Optional<SubscriptionEntity> fetchSubscriptionId(Long subscriptionId) {
        return subscriptionRepository.findById(subscriptionId);
    }

    // update operation
    @Override
    public SubscriptionEntity updateSubscription(SubscriptionEntity subscription, Long subscriptionId) {
//        SubscriptionEntity depDB = subscriptionRepository.findById(subscriptionId).get();
//
//        if(Objects.nonNull(subscription.getPlanName()) && !"".equalsIgnoreCase(subscription.getPlanName()) )
//        {
//            depDB.setPlanName(subscription.getPlanName());
//
//        }
//
//        if(Objects.nonNull(subscription.getCost()) && subscription.getCost()>0 )
//        {
//            depDB.setCost(subscription.getCost());
//        }
    // prefer not to be able to change the plans , only the owner should be able to aka he who has access to db
        return subscription;
    }

    // delete operation
    @Override
    public void deleteSubscriptionById(Long subscriptionId) {
        subscriptionRepository.deleteById(subscriptionId);
    }

}