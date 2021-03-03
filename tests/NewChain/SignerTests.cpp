// Copyright © 2017-2020 Trust Wallet.
//
// This file is part of Trust. The full Trust copyright notice, including
// terms governing use, modification, and redistribution, is contained in the
// file LICENSE at the root of the source code distribution tree.

#include "NewChain/Signer.h"
#include "NewChain/Address.h"
#include "HexCoding.h"
#include "PrivateKey.h"
#include "PublicKey.h"

#include <gtest/gtest.h>

using namespace TW;
using namespace TW::NewChain;


TEST(NewChainSigner, Sign) {

//    auto key = PrivateKey(parse_hex("0xdbe4616161f04b1b3e848acf8195614e4b85891e0cc23c935aa55d89dc693607"));
//    auto publicKey = key.getPublicKey(TWPublicKeyTypeNIST256p1Extended);
//    auto from = Address(publicKey);
//    auto to = Address("0x053Bc936209f216272b7736C11140CdE98eeA52B");
//    auto transaction = Transaction(...)
//    auto signature = Signer::sign(key, transaction);
//    auto result = transaction.serialize(signature);
//    ASSERT_EQ(hex(serialized), "__RESULT__");
}
