package challenge.buildrun.picpay.service;

import challenge.buildrun.picpay.dto.CreateWalletDto;
import challenge.buildrun.picpay.entity.Wallet;
import challenge.buildrun.picpay.repository.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {

        walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());

        return walletRepository.save(dto.toWallet());
    }
}
