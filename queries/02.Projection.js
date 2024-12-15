/*
stocks> db.reits.findOne()
{
    _id: ObjectId('675e44069385207b0e4a9b7f'),
        rank: 1,
    symbol: 'CTO',
    name: 'CTO Realty Growth, Inc.',
    rating: 4.97,
    sArating: 4.16,
    wsRating: 4.57,
    marketCap: 588041600,
    dividendYield: 0.077471964,
    valuation: 'A',
    growth: 'A+',
    profitability: 'C-',
    momentum: 'C+',
    ePSRev: 'A+',
    marketCapInBillions: 0.5880416,
    averageRating: { count: 3, averageScore: 4.5666666 }
}
 */

db.reits.find({growth: 'A'});
db.reits.find({growth: {$in: ['A', "A+"]}});
db.reits.find({growth: {$in: ['A', "A+", "B+", 'B']} }, {_id: false, symbol: true, dividendYield: true, marketCapInBillions: true});
