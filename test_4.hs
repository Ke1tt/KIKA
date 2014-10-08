madal 
  :: (Num a, Ord a)
  => [a] -> Bool
madal xs
  = let
      abi n (x:xs)
       = 0 <= x && x <= n && abi (n + 1) xs
      abi _ _
       = True
      in
      abi 0 xs