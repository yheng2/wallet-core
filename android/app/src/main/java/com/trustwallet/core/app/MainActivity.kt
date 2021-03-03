package com.trustwallet.core.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.protobuf.ByteString
import com.trustwallet.core.app.utils.Numeric
import com.trustwallet.core.app.utils.toHexByteArray
import wallet.core.java.AnySigner
import wallet.core.jni.CoinType
import wallet.core.jni.HDWallet
import wallet.core.jni.PrivateKey
import wallet.core.jni.proto.NewChain

class MainActivity : AppCompatActivity() {
    init {
        System.loadLibrary("TrustWalletCore")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mnemonic = "shoot island position soft burden budget tooth cruel issue economy destroy above"
        val wallet = HDWallet(mnemonic, "")
        val address = wallet.getAddressForCoin(CoinType.NEWCHAIN)
        println("address ${address}")
        initTransaction(wallet.getKeyForCoin(CoinType.NEWCHAIN))
    }

    fun initTransaction(mPrivateKey: PrivateKey) {
        val signingInput = NewChain.SigningInput.newBuilder()
        signingInput.apply {
            privateKey = ByteString.copyFrom(mPrivateKey.data())
            toAddress = "0x3535353535353535353535353535353535353535"
            chainId = ByteString.copyFrom("0x3EA".toHexByteArray())
            nonce = ByteString.copyFrom("0x0".toHexByteArray())
            gasPrice = ByteString.copyFrom("0x04a817c800".toHexByteArray())
            gasLimit = ByteString.copyFrom("0x5208".toHexByteArray())
            transaction = NewChain.Transaction.newBuilder().apply {
                transfer = NewChain.Transaction.Transfer.newBuilder().apply {
                    amount = ByteString.copyFrom("0x0de0b6b3a7640000".toHexByteArray())
                }.build()
            }.build()
        }

        val output = AnySigner.sign(signingInput.build(), CoinType.NEWCHAIN, NewChain.SigningOutput.parser())
        val encoded = AnySigner.encode(signingInput.build(), CoinType.NEWCHAIN)
        println(Numeric.toHexString(output.toByteArray()))
        println(encoded)
    }
}
