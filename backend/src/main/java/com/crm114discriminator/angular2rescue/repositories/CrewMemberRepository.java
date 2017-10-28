package com.crm114discriminator.angular2rescue.repositories;

import com.crm114discriminator.angular2rescue.entities.CrewMember;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Steve on 22/09/2017.
 */
public interface CrewMemberRepository extends CrudRepository<CrewMember, Long> {
}
