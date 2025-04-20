package challenge.buildrun.picpay.repository;

import challenge.buildrun.picpay.entity.WalletType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTypeRepository  extends JpaRepository<WalletType, Long> {
}
