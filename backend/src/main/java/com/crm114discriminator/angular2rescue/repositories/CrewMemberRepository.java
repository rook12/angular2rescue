package com.crm114discriminator.angular2rescue.repositories;

import com.crm114discriminator.angular2rescue.entities.CrewMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Steve on 22/09/2017.
 */
public interface CrewMemberRepository extends PagingAndSortingRepository<CrewMember, Long> {
    Page<CrewMember> findAll(Pageable pageable);
}
