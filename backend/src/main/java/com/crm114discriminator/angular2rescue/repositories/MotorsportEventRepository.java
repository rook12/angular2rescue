package com.crm114discriminator.angular2rescue.repositories;

import com.crm114discriminator.angular2rescue.entities.MotorsportEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Steve on 22/09/2017.
 */
public interface MotorsportEventRepository extends PagingAndSortingRepository<MotorsportEvent, Long> {

    MotorsportEvent findByName(String name);

    MotorsportEvent findById(Integer id);

    Page<MotorsportEvent> findAll(Pageable pageable);
}
