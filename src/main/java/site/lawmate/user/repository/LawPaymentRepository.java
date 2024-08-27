package site.lawmate.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import site.lawmate.user.domain.dto.LawPaymentDto;
import site.lawmate.user.domain.model.LawPayment;

import java.util.List;
import java.util.Optional;

public interface LawPaymentRepository extends JpaRepository<LawPayment, Long> {
    LawPayment findByImpUid(String impUid);

    Optional<LawPayment> findByLawyer(String lawyer);
}
