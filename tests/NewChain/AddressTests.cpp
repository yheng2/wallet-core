// Copyright © 2017-2020 Trust Wallet.
//
// This file is part of Trust. The full Trust copyright notice, including
// terms governing use, modification, and redistribution, is contained in the
// file LICENSE at the root of the source code distribution tree.

#include "HexCoding.h"
#include "NewChain/Address.h"
#include "PublicKey.h"
#include "PrivateKey.h"
#include <gtest/gtest.h>
#include <vector>

using namespace TW;
using namespace TW::NewChain;

TEST(NewChainAddress, Valid) {
    ASSERT_FALSE(Address::isValid("abc"));
    ASSERT_FALSE(Address::isValid("aaeb60f3e94c9b9a09f33669435e7ef1beaed"));
    ASSERT_FALSE(Address::isValid("fB6916095ca1df60bB79Ce92cE3Ea74c37c5d359"));
}

TEST(NewChainAddress, Invalid) {
    ASSERT_FALSE(Address::isValid("053Bc936209f216272b7736C11140CdE98eeA52B"));
}

TEST(NewChainAddress, FromPrivateKey) {
    auto privateKey = PrivateKey(parse_hex("0xdbe4616161f04b1b3e848acf8195614e4b85891e0cc23c935aa55d89dc693607"));
    auto address = Address(privateKey.getPublicKey(TWPublicKeyTypeNIST256p1Extended));
    ASSERT_EQ(address.string(), "0x053Bc936209f216272b7736C11140CdE98eeA52B");
}

TEST(NewChainAddress, FromString) {
    auto address = Address("0x053Bc936209f216272b7736C11140CdE98eeA52B");
    ASSERT_EQ(address.string(), "0x053Bc936209f216272b7736C11140CdE98eeA52B");
}
