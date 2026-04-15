-- ===== InterviewForge Question Bank =====
-- Seed data for interview questions across all domains

-- ===== DSA & Algorithms =====
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('DSA', 'EASY', 'What is the difference between an array and a linked list?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('DSA', 'EASY', 'Explain how a stack works and give a real-world example.', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('DSA', 'EASY', 'What is the time complexity of binary search?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('DSA', 'MEDIUM', 'Explain the concept of dynamic programming with an example.', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('DSA', 'MEDIUM', 'How would you detect a cycle in a linked list?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('DSA', 'MEDIUM', 'Explain the difference between BFS and DFS. When would you use each?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('DSA', 'MEDIUM', 'Implement a function to find the longest palindromic substring.', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('DSA', 'HARD', 'Solve the 0/1 Knapsack problem using dynamic programming.', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('DSA', 'HARD', 'Implement LRU Cache with O(1) get and put operations.', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('DSA', 'HARD', 'Find all connected components in an undirected graph.', 'TECHNICAL');

-- ===== System Design =====
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('System Design', 'MEDIUM', 'How would you design a URL shortening service like bit.ly?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('System Design', 'MEDIUM', 'Design a notification system for 10 million users.', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('System Design', 'HARD', 'Design a messaging system like WhatsApp.', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('System Design', 'HARD', 'How would you design YouTube''s video upload and streaming system?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('System Design', 'HARD', 'Design a distributed cache system.', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('System Design', 'HARD', 'How would you design Uber''s real-time location tracking?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('System Design', 'MEDIUM', 'How would you build a search autocomplete feature?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('System Design', 'HARD', 'Design a rate limiter for a large-scale API gateway.', 'TECHNICAL');

-- ===== Frontend Dev =====
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Frontend', 'EASY', 'What is the Virtual DOM and how does React use it?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Frontend', 'EASY', 'Explain the CSS box model in detail.', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Frontend', 'MEDIUM', 'How does JavaScript event bubbling work?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Frontend', 'MEDIUM', 'What are React Hooks and why were they introduced?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Frontend', 'MEDIUM', 'Explain the difference between null and undefined in JavaScript.', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Frontend', 'HARD', 'How do you optimize the performance of a React application?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Frontend', 'MEDIUM', 'What is CORS and how do you handle it?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Frontend', 'EASY', 'Describe your approach to responsive design.', 'TECHNICAL');

-- ===== Backend Dev =====
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Backend', 'EASY', 'Explain the difference between SQL and NoSQL databases.', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Backend', 'EASY', 'What is REST and what are its key principles?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Backend', 'MEDIUM', 'How would you design a rate limiting system?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Backend', 'MEDIUM', 'What is a microservices architecture and its pros/cons?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Backend', 'MEDIUM', 'How do you handle database transactions?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Backend', 'MEDIUM', 'Explain JWT authentication flow.', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Backend', 'HARD', 'What is caching and when would you use Redis vs Memcached?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Backend', 'HARD', 'How do you ensure API security in a production environment?', 'TECHNICAL');

-- ===== HR & Behavioral =====
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('HR', 'EASY', 'Tell me about yourself.', 'HR');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('HR', 'EASY', 'What is your greatest strength and weakness?', 'HR');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('HR', 'MEDIUM', 'Describe a time you handled a conflict with a team member.', 'HR');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('HR', 'EASY', 'Where do you see yourself in 5 years?', 'HR');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('HR', 'MEDIUM', 'Why do you want to work at our company?', 'HR');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('HR', 'MEDIUM', 'Tell me about a time you failed and what you learned from it.', 'HR');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('HR', 'MEDIUM', 'Describe a situation where you showed leadership.', 'HR');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('HR', 'HARD', 'How do you handle pressure and tight deadlines?', 'HR');

-- ===== ML & AI =====
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('ML', 'MEDIUM', 'Explain the bias-variance tradeoff.', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('ML', 'MEDIUM', 'What is gradient descent and how does it work?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('ML', 'MEDIUM', 'Explain overfitting and how to prevent it.', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('ML', 'EASY', 'What is the difference between supervised and unsupervised learning?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('ML', 'HARD', 'How does a neural network learn through backpropagation?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('ML', 'MEDIUM', 'Explain precision, recall, and F1 score.', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('ML', 'HARD', 'What are transformers and why are they important in NLP?', 'TECHNICAL');

-- ===== General / Software Engineer =====
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Software Engineer', 'EASY', 'Tell me about yourself and your experience as a software engineer.', 'MIXED');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Software Engineer', 'MEDIUM', 'Explain the difference between a stack and a queue, and when would you use each?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Software Engineer', 'MEDIUM', 'What is time complexity and why does it matter? Give an example.', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Software Engineer', 'MEDIUM', 'Describe a challenging technical problem you solved. What was your approach?', 'MIXED');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Software Engineer', 'HARD', 'How would you design a URL shortening service like bit.ly?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Software Engineer', 'MEDIUM', 'Explain the concept of SOLID principles with examples.', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Software Engineer', 'MEDIUM', 'What is the difference between REST and GraphQL?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Software Engineer', 'HARD', 'How do you handle concurrency issues in multi-threaded programming?', 'TECHNICAL');

-- ===== Full Stack Developer =====
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Full Stack Developer', 'MEDIUM', 'What is your preferred tech stack and why?', 'MIXED');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Full Stack Developer', 'MEDIUM', 'How do you handle authentication between frontend and backend?', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Full Stack Developer', 'HARD', 'Describe how you would deploy a full-stack application to production.', 'TECHNICAL');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('Full Stack Developer', 'MEDIUM', 'How do you manage state in a complex web application?', 'TECHNICAL');

-- ===== General =====
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('General', 'EASY', 'Tell me about yourself and your technical background.', 'MIXED');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('General', 'EASY', 'What is your strongest skill in software development?', 'MIXED');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('General', 'EASY', 'Describe a project you are most proud of.', 'MIXED');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('General', 'EASY', 'How do you keep yourself updated with the latest technology trends?', 'MIXED');
INSERT INTO questions (domain, difficulty, question_text, category) VALUES ('General', 'EASY', 'What motivates you as a developer?', 'MIXED');
