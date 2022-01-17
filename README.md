# ShoppingCheckout

This project is about the final process of checking out from a shop

Using h2 in memory db, the project consists of several layers:

- Model Layer
  -- consists of the basic model entities: Order, OrderDTO and Item
- Repository layer
  -- for the Item and the Order entities crud opertations
- Service Layer
  -- Order service for the order validations logic,  ItemService for the shopping items functions and Paypal service
- Controller Layer
  -- OrderController: the main one, through it we create and validate the order created, to see the shopping items already existing go to the Items Controller
  -- ItemsController: for viewing shopping items available.
  -- PaypalController: for Paypal payment service.

