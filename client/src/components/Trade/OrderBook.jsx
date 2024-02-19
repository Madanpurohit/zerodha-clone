import React from 'react';

const OrderBook = () => {
  return (
    <div className="flex items-left justify-center">
      <div className="container mx-auto p-6 bg-white rounded-md shadow-md w-full md:w-2/3 lg:w-1/2">
        <h1 className="text-3xl font-bold mb-6 text-gray-800">Stock Order Book</h1>

        {/* Buy Orders */}
        <div>
          <h2 className="text-xl font-semibold mb-4 text-green-600">Buy Orders</h2>
          <table className="w-full border-collapse bg-green-50 rounded-md overflow-hidden">
            <thead>
              <tr>
                <th className="py-2 text-left border-b bg-green-200">Price</th>
                <th className="py-2 text-left border-b bg-green-200">Quantity</th>
              </tr>
            </thead>
            <tbody>
              {/* Add dynamic data here using your backend or sample data */}
              <tr className="transition hover:bg-green-100">
                <td className="py-2 border-b">$120.50</td>
                <td className="py-2 border-b">10</td>
              </tr>
              <tr className="transition hover:bg-green-100">
                <td className="py-2 border-b">$120.40</td>
                <td className="py-2 border-b">5</td>
              </tr>
              {/* Add more rows as needed */}
            </tbody>
          </table>
        </div>

        {/* Sell Orders */}
        <div className="mt-6">
          <h2 className="text-xl font-semibold mb-4 text-red-600">Sell Orders</h2>
          <table className="w-full border-collapse bg-red-50 rounded-md overflow-hidden">
            <thead>
              <tr>
                <th className="py-2 text-left border-b bg-red-200">Price</th>
                <th className="py-2 text-left border-b bg-red-200">Quantity</th>
              </tr>
            </thead>
            <tbody>
              {/* Add dynamic data here using your backend or sample data */}
              <tr className="transition hover:bg-red-100">
                <td className="py-2 border-b">$121.00</td>
                <td className="py-2 border-b">8</td>
              </tr>
              <tr className="transition hover:bg-red-100">
                <td className="py-2 border-b">$121.20</td>
                <td className="py-2 border-b">12</td>
              </tr>
              {/* Add more rows as needed */}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default OrderBook;
