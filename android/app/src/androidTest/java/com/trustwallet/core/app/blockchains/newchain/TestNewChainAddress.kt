// Copyright © 2017-2020 Trust Wallet.
//
// This file is part of Trust. The full Trust copyright notice, including
// terms governing use, modification, and redistribution, is contained in the
// file LICENSE at the root of the source code distribution tree.

package com.trustwallet.core.app.blockchains.newchain

import com.trustwallet.core.app.utils.toHex
import com.trustwallet.core.app.utils.toHexByteArray
import org.junit.Assert.assertEquals
import org.junit.Test
import wallet.core.jni.*

class TestNewChainAddress {

    init {
        System.loadLibrary("TrustWalletCore")
    }

    @Test
    fun testAddress() {
        println("test address")
        val key = PrivateKey("0xdbe4616161f04b1b3e848acf8195614e4b85891e0cc23c935aa55d89dc693607".toHexByteArray())
        val pubkey = key.getPublicKeySecp256k1(false)
        val address = AnyAddress(pubkey, CoinType.NEWCHAIN)
        println(address)
        val expected = AnyAddress("0x053Bc936209f216272b7736C11140CdE98eeA52B", CoinType.NEWCHAIN)

        assertEquals(pubkey.data().toHex(), "0x9f14f4a2a00480b1e4da77cc312b82b866c32c846670039fb1295855752740a805e19b4dfd27234a2a8d081aa107b1063d215fe4388519a7e464439162dd9cc0")
        assertEquals(address.description(), expected.description())
    }
}
