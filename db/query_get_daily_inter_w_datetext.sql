SELECT * FROM repo.daily_inter di 
JOIN daily_inter_date did ON did.daily_inter_id = di.daily_inter_id
WHERE di.ticker_id =
( SELECT id FROM repo.nasdaq_ticker WHERE ticker = 'INTC') 
ORDER BY di.timestamp;