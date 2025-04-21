package challenge.buildrun.picpay.dto;

import challenge.buildrun.picpay.entity.Wallet;
import challenge.buildrun.picpay.entity.WalletType;

public record CreateWalletDto(
        String fullname,
        String cpfCnpj,
        String email,
        String password,
        WalletType.EnumWalletType walletType) {

    public Wallet toWallet() {
        return new Wallet(
                fullname,
                cpfCnpj,
                email,
                password,
                walletType.get()
        );
    }
}
